package com.br.desaf.mvp


interface MVP {
    interface Presenters {
        fun initLoadData()
        fun processDados(s: String)
        fun retornErro(erro: String)
    }

    interface View {
        fun retornoProcess()
        fun erroTrans()
    }

    interface Model {
        fun conexaoHttp()
        fun retornoHttp()
        fun erroHttp()
    }
}