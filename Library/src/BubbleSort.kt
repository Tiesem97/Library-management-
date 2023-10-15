//Shifat Mohammed 001027898
//Library Management CW COMP - 1815
class BubbleSort {

    fun bubbleSort(listBooks: ArrayList<Books>) {
        var sorted = false
        var temp: Books //declares a variable called temp of type Books. It is used to store a temporary value while sorting the list.

        while (!sorted) {
            sorted = true
            for (i in 0 until listBooks.size - 1) { //the loop will continue to execute as long as i is less than the size of the listBooks list - 1

               //compares author name of the index i of the listBook list with the author name of the index i+1, which is the next one.
                if (listBooks[i].author.compareTo(listBooks[i + 1].author) > 0) { //
                   //the compared element are swapped if  listBooks[i].author > istBooks[i + 1].author
                    temp = listBooks[i]
                    listBooks[i] = listBooks[i + 1]
                    listBooks[i + 1] = temp
                    sorted = false
                }
            }
        }
    }


}