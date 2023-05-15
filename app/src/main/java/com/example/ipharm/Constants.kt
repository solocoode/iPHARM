package com.example.ipharm

object Constants {
    // Arraylist and return the Arraylist
    fun getProductData():ArrayList<products>{
        // create an arraylist of type employee class
        val productsList=ArrayList<products>()
        val emp1=products("Product 1","ksh 100")
        productsList.add(emp1)
        val emp2=products("Product 2","ksh 200")
        productsList.add(emp2)
        val emp3=products("Product 3","ksh 300")
        productsList.add(emp3)
        val emp4=products("Product 4","ksh 400")
        productsList.add(emp4)
        val emp5=products("Product 5","ksh 500")
        productsList.add(emp5)
        val emp6=products("Product 6","ksh 600")
        productsList.add(emp6)
        val emp7=products("Product 7","ksh 700")
        productsList.add(emp7)
        val emp8=products("Product 8","ksh 800")
        productsList.add(emp8)
        val emp9=products("Product 9","ksh 900")
        productsList.add(emp9)
        val emp10=products("Product 10","ksh 1000")
        productsList.add(emp10)
        val emp11=products("Product 11","ksh1100")
        productsList.add(emp11)
        val empdb=products("","")
        productsList.add(empdb)

        return  productsList
    }
}