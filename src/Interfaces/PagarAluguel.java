package Interfaces;

import Models.Aluguel;

public interface PagarAluguel<T> {
    double calcularPrecoFinal(Aluguel aluguel);
    void pagarConta(Aluguel aluguel);
}
