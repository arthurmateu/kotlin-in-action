// Inline classes: avoids having to create a bunch of classes for small things, while keeping things type-safe. Classes elegible must have exactly one property and not participate in class hierarchies.
@JvmInline
class UsdCent(val amount: Int)

fun addExpense(expense: UsdCent) { /* ... */ }

interface PrettyPrintable {
    fun prettyPrint()
}

@JvmInline
    value class UsdCent(val amount: Int): PrettyPrintable {
    val salesTax get() = amount * 0.06
    override fun prettyPrint() = println("${amount}¢")
}

fun main() {
    addExpense(UsdCent(147))

    val expense = UsdCent(1_99)
    println(expense.salesTax)
    expense.prettyPrint()
}
