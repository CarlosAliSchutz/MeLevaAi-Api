package br.com.cwi.api.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class UtilsCorridaService {

    private static final double RAIO_TERRA_KM = 6371;

    public static double getDistanciaCorrida(double lat1, double long1, double lat2, double long2) {
        return Math.acos(Math.sin(lat2 * Math.PI / 180.0) * Math.sin(lat1 * Math.PI / 180.0) +
                Math.cos(lat2 * Math.PI / 180.0) * Math.cos(lat1 * Math.PI / 180.0) *
                        Math.cos((long1 - long2) * Math.PI / 180.0)) * RAIO_TERRA_KM;
    }

    public static int getTempoChegadaEstimada(double distancia) {
        double velocidade = 30;

        double tempoEmHoras = distancia / velocidade;

        double tempoEmSegundos = tempoEmHoras * 60 * 60;

        return (int)Math.round(tempoEmSegundos);
    }

    public static BigDecimal getPrecoCorrida(int tempo) {
        BigDecimal precoPorSegundo = new BigDecimal("0.2");
        return precoPorSegundo.multiply(new BigDecimal(tempo));
    }

    public static int calcularTempoChegada() {
        return ((int)(5 + Math.random() * (10 - 5 + 1)));
    }

    public static int calcularDuracaoCorrida(LocalDateTime inicio, LocalDateTime fim) {
        return (int) ChronoUnit.SECONDS.between(inicio, fim);
    }

    public static BigDecimal cobrancaCorrida(BigDecimal contaPasseiro, BigDecimal descontado) {
        return contaPasseiro.subtract(descontado);
    }

    public static BigDecimal cobrancaCorridaMotorista(BigDecimal contaMotorista, BigDecimal valor) {
        return contaMotorista.add(valor);
    }
}
