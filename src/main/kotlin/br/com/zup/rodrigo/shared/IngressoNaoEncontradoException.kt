package br.com.zup.rodrigo.shared

import java.lang.RuntimeException
import javax.inject.Singleton

@Singleton
class IngressoNaoEncontradoException(message: String) : RuntimeException(message){
}