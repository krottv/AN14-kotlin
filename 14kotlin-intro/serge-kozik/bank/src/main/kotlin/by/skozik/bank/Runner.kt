package by.skozik.bank

/**
 * Банк. Имеется банк с кассирами, клиентами и их счетами.
 * Клиент может снимать/ложить/переводить/оплачивать/обменивать.
 * Кассир последовательно обслуживает клиентов.
 * Поток-наблюдатель следит, чтобы в кассах всегда были наличные,
 * при скоплении наличных более определенном суммы часть наличных переводится в хранилище.
 */
import by.skozik.bank.common.BankUtil.generateClientTasks
import by.skozik.bank.currency.CurrencyAmount
import by.skozik.bank.currency.CurrencyType
import by.skozik.bank.dao.AccountDao
import by.skozik.bank.office.OfficeManager
import by.skozik.bank.treasury.Treasury
import java.math.BigDecimal
import java.util.stream.Collectors

const val numberOfCashier: Int = 4
const val numberOfTasks: Int = 10

fun main(args: Array<String>) {
    val availableAccounts : List<String> = listOf("111", "222", "333", "444")
    Treasury.initTreasury()
    AccountDao.initAccountDao(availableAccounts.stream().collect(Collectors.toMap(
        { a: String? -> a },
        { CurrencyAmount(BigDecimal.ZERO, CurrencyType.TALENT) })))
    val officeManager = OfficeManager(numberOfCashier)
    val clientTasks = generateClientTasks(numberOfTasks, availableAccounts, 100, officeManager)
    for (clientTask in clientTasks) {
        Thread(clientTask).start()
    }
    try {
        Thread.sleep((BANK_WORKING_TIME_SEC * 1000).toLong())
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
    Treasury.instance?.stopJob()
    officeManager.stopCashierPool()
}