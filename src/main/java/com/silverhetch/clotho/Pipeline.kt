package com.silverhetch.clotho

interface Pipeline<T> {
    fun compute(): T
}