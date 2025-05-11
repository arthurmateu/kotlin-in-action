// annotate with @. useful examples: @Deprecated and @Supress
// peep this https://github.com/Kotlin/kotlin-in-action-2e-jkid/tree/main/src/test/kotlin/examples

// You can annotate variables to have specific properties during serialization to json
data class Person(
    @JsonName("alias") val firstName: String,
    @JsonExclude val age: Int? = null
)

// to make an annotation, just prepend "annotate" to the class declaration