// Note: sample code, needs more stuff to be compiled and such
@Composable
fun MessageCard(modifier: Modifier, message: Message) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(modifier.clickable { isExpanded = !isExpanded }) {
        Text(message.body)
        if (isExpanded) {
            MessageDetails(message)
        }
    }
}

@Composable
fun MessageDetails(message: Message) { /* ... */ }
