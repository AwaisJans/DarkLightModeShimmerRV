package com.jans.rv.shimmer.dark.mode.app.apiUtil

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jans.rv.shimmer.dark.mode.app.model.Carts
import com.jans.rv.shimmer.dark.mode.app.model.Categories
import com.jans.rv.shimmer.dark.mode.app.model.Products
import com.jans.rv.shimmer.dark.mode.app.model.Users
import org.json.JSONArray

object ApiService {

    private const val BASE_URL = "https://fakestoreapi.com"



    // get items

    fun getProducts(callback: (List<Products>?) -> Unit, context:Context) {
        val url = "$BASE_URL/products/"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                val posts = parseProductsJsonArray(response)
                callback(posts)
            },
            { _ ->
                callback(null)
            }
        )

        Volley.newRequestQueue(context).add(jsonArrayRequest)
    }


    fun getUsers(callback: (List<Users>?) -> Unit, context:Context) {
        val url = "$BASE_URL/users/"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                val posts = parseUsersJsonArray(response)
                callback(posts)
            },
            { _ ->
                callback(null)
            }
        )

        Volley.newRequestQueue(context).add(jsonArrayRequest)
    }

    fun getCarts(callback: (List<Carts>?) -> Unit, context:Context) {
        val url = "$BASE_URL/carts/"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                val posts = parseCartsJsonArray(response)
                callback(posts)
            },
            { _ ->
                callback(null)
            }
        )

        Volley.newRequestQueue(context).add(jsonArrayRequest)
    }

    fun getCategories(callback: (List<Categories>?) -> Unit, context:Context) {
        val url = "$BASE_URL/products/category/jewelery/"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                val posts = parseCategoriesJsonArray(response)
                callback(posts)
            },
            { _ ->
                callback(null)
            }
        )

        Volley.newRequestQueue(context).add(jsonArrayRequest)
    }



    // parse json methods

    private fun parseCategoriesJsonArray(jsonArray: JSONArray): List<Categories> {
        return Gson().fromJson<List<Categories>?>(jsonArray.toString(), object : TypeToken<List<Categories>>() {}.type)!!
    }

    private fun parseCartsJsonArray(jsonArray: JSONArray): List<Carts> {
        return Gson().fromJson<List<Carts>?>(jsonArray.toString(), object : TypeToken<List<Carts>>() {}.type)!!
    }

    private fun parseUsersJsonArray(jsonArray: JSONArray): List<Users> {
        return Gson().fromJson<List<Users>?>(jsonArray.toString(), object : TypeToken<List<Users>>() {}.type)!!
    }

    private fun parseProductsJsonArray(jsonArray: JSONArray): List<Products> {
        return Gson().fromJson<List<Products>?>(jsonArray.toString(), object : TypeToken<List<Products>>() {}.type)!!

    }

}
