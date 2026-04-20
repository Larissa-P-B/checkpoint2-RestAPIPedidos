package br.com.fiap3ess.checkpoint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Pedidos")
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do cliente é obrigatório")
    private String clienteNome;

    private LocalDate pedidoData;

    @DecimalMin(value = "0.0", message = "O valor não pode ser negativo")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal valorTotal;

    @PrePersist
    public void prePersist() {
        if (this.pedidoData == null) {
            this.pedidoData = LocalDate.now();
        }
    }


}


