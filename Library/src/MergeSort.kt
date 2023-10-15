//Shifat Mohammed 001027898
//Library Management CW COMP - 1815
class MergeSort {

    fun mergeSort(listBooks: ArrayList<Books>) {
        if (listBooks.size <= 1) {
            return
        }

        // Split the list in half
        val mid = listBooks.size / 2
        val left = ArrayList(listBooks.subList(0, mid))
        val right = ArrayList(listBooks.subList(mid, listBooks.size))
        mergeSort(left)
        mergeSort(right)
        merge(listBooks, left, right)
    }

    fun merge(listBooks: ArrayList<Books>, left: ArrayList<Books>, right: ArrayList<Books>) {
        // Keep track of the current index in the left, right, and list lists
        var leftIndex = 0
        var rightIndex = 0
        var listIndex = 0


        // Compare the elements at the current indices of the left and right lists,
        // and copy the smaller element into the list
        while (leftIndex < left.size && rightIndex < right.size) {
            if (left[leftIndex].author.compareTo(right[rightIndex].author) < 0) {
                listBooks[listIndex] = left[leftIndex]
                leftIndex++
            } else {
                listBooks[listIndex] = right[rightIndex]
                rightIndex++
            }
            listIndex++
        }


        // Copy any remaining elements from the left list
        while (leftIndex < left.size) {
            listBooks[listIndex] = left[leftIndex]
            leftIndex++
            listIndex++
        }
        while (rightIndex < right.size) {
            listBooks[listIndex] = right[rightIndex]
            rightIndex++
            listIndex++
        }
    }




}