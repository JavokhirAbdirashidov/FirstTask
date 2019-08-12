package jawoheer.example.myapplication

class BookInfo(var initialPoint: String, var destination: String, var date: String, var cost: String)
{
    override fun toString(): String {
        return "BookInfo(initialPoint='$initialPoint', destination='$destination', date='$date', cost='$cost')"
    }
}