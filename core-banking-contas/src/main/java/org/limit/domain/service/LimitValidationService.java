package com.bank.account.limit.domain.service;

import com.bank.account.limit.domain.model.AccountLimit;
import com.bank.account.limit.domain.model.LimitInterval;
import com.bank.account.limit.domain.model.LimitType;

import java.math.BigDecimal;

public class LimitValidationService {

    public boolean isAllowed(
            AccountLimit accountLimit,
            LimitType limitType,
            BigDecimal operationAmount
    ) {

        if (accountLimit == null) {
            return false; // não existe limite configurado para validação
        }

        if (limitType == null) {
            return false; // tipo da operação é obrigatório
        }

        if (operationAmount == null || operationAmount.signum() <= 0) {
            return false; // operação deve possuir valor positivo
        }

        if (!accountLimit.isActive()) {
            return false; // limite inativo não pode autorizar operações
        }

        if (accountLimit.getLimitType() != limitType) {
            return false; // limite deve corresponder ao tipo da operação
        }

        return operationAmount.compareTo(
                accountLimit.getAvailableAmount()
        ) <= 0; // verifica se o valor está dentro do limite disponível
    }

    public boolean exceedsLimit(
            AccountLimit accountLimit,
            BigDecimal operationAmount
    ) {

        if (accountLimit == null || operationAmount == null) {
            return true; // dados inválidos não devem ser autorizados
        }

        return operationAmount.compareTo(
                accountLimit.getAvailableAmount()
        ) > 0; // identifica operação acima do limite disponível
    }

    public boolean supportsInterval(
            AccountLimit accountLimit,
            LimitInterval interval
    ) {

        if (accountLimit == null || interval == null) {
            return false; // parâmetros obrigatórios não informados
        }

        return accountLimit.getLimitInterval() == interval; // verifica intervalo configurado
    }
}