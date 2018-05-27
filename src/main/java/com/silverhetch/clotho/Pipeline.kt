package com.silverhetch.elizabeth.arch

interface Pipeline<T> {
    fun compute(): T
}