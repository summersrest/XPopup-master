package com.lxj.xpopup.widget.statelayout

enum class State {
    None,
    Loading, // when loading data
    Content, // show data
    Empty, // no data
    Error // load data fail
}