package com.silverhetch.elizabeth

interface Pipeline<T> {
    fun compute(): T
}