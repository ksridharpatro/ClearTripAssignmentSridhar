package com.example.cleartripassignmentsridhar.util

import org.json.JSONException
import org.json.JSONObject

fun getKeysFromJsonObject(jsonObjectInString: JSONObject?): List<String> {
    val keySet: MutableList<String> = ArrayList()
    jsonObjectInString?.let {
        val iteratorKeySet = jsonObjectInString.keys()
        while (iteratorKeySet.hasNext()) {
            keySet.add(iteratorKeySet.next())
        }
    }
    return keySet
}

fun getStringFromJsonObject(jsonObject: JSONObject?, key: String): String {
    if (jsonObject == null) {
        return ""
    }
    return try {
        jsonObject.getString(key)
    } catch (e: JSONException) {
        ""
    }
}