#!/usr/bin/env python3
"""
Un programa simple en Python para sumar dos números enteros ingresados por el usuario.
"""

def solicitar_numero_entero(mensaje_prompt: str) -> int:
    """
    Solicita al usuario un número entero hasta que se ingrese uno válido.

    Args:
        mensaje_prompt: El mensaje a mostrar al usuario al solicitar la entrada.

    Returns:
        El número entero ingresado por el usuario.
    """
    while True:
        try:
            numero_str = input(mensaje_prompt)
            numero_int = int(numero_str)
            return numero_int
        except ValueError:
            print("Entrada inválida. Por favor, ingrese un número entero.")

def main():
    """
    Función principal para ejecutar el programa sumador.
    Solicita dos números enteros, calcula su suma y muestra el resultado.
    """
    print("Programa Sumador de dos números enteros en Python")

    num1 = solicitar_numero_entero("Ingrese el primer número entero: ")
    num2 = solicitar_numero_entero("Ingrese el segundo número entero: ")

    suma = num1 + num2

    print(f"La suma de {num1} y {num2} es: {suma}")

if __name__ == "__main__":
    main()
