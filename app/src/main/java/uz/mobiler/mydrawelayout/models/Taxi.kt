package uz.mobiler.mydrawelayout.models

class Taxi {

    var image: String? = null
    var text1: String? = null
    var text2: String? = null
    var time: String? = null

    constructor(image: String?, text1: String?, text2: String?, time: String?) {
        this.image = image
        this.text1 = text1
        this.text2 = text2
        this.time = time
    }
}