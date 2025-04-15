interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focuseable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focuseable!")
}

class Button: Clickable, Focuseable { // You can extend only one class!
    override fun click() = println("Click!") // override is mandatory
    // since we don't define showOff, we just get the default behavior from Clickable

    // You must override this function, because it inherits many implementations of it
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focuseable>.showOff()
    }
}

/* INHERITANCE 
 * final    -> can't be overriden (default)
 * open     -> can be overriden
 * abstract -> must be overriden
 * override -> overrides superclass
 */
open class RichButton: Clickable { // Inheritable, since it's open
    fun disable() { /* ... */ } // Implicitly final, meaning that you can't override it
    open fun animate() { /* ... */ } // Overrideable
    override fun click() { /* ... */ } // Overrides an open function and is overrideable
}

abstract class Animated { // Can't be instantiated; everything is open
    abstract val animationSpeed: Double // Must be overriden
    val keyframes: Int = 20
    open val frames: Int = 60
    abstract fun animate // Again, like everything abstracted, must be overriden
    open fun stopAnimating() { /* ... */ }
    fun animateTwice() { /* ... */ }
}

class ThemedButton: RichButton() {
    fun disable() { /* ... */ }
    open fun animate() { /* ... */ }
    override fun click() { /* ... */ } // Overrideable because of Clickeable
}

/* VISIBILITY MODIFIERS
 * public       -> visible everywhere (default)
 * protected    -> visible in subclasses
 * private      -> visible inside a class | top-level declarations: inside a file
 * internal     -> visible inside a module
 */
internal open class TalkativeButton {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

fun TalkativeButton.giveSpeech() { // Error: public member accessing internal
    yell() // Error: private
    whisper() // Error: protected
}

/* NESTING
 * Nested classes that don't store a reference to an outer class don't need any identifiers
 * Only inner classes (which stores a reference to an outer class) need to use `inner`
 *      This allows you to access the outer class with `this@Outer`
 */
interface State: Serializable

interface View{
    fun getCurrentState(): State
    fun restoreState(state: State) { /* ... */ }
}

class Button: View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) { /* ... */ }
    class ButtonState: State { /* ... */ }
}

/* SEALED
 * Restricts the possibility of creating subclasses to same package as the sealed class
 * Also works with interfaces
 */

sealed class Expr
class Num(val value: Int): Expr()
class Sum(val left: Expr, val right: Expr): Expr()

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        // You don't need a default branch since Expr is sealed
        // ...meaning everything is known at compile time
        // If you added a Mul() class, it would need to be dealt with on a branch
    }


fun main() {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}
