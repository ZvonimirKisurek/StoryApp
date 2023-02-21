package com.example.manageme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform