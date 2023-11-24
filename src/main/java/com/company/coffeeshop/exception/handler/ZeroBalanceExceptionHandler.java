package com.company.coffeeshop.exception.handler;

import com.company.coffeeshop.exception.ZeroBalanceException;
import io.jmix.ui.Notifications;
import io.jmix.ui.exception.AbstractUiExceptionHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

@Component("cs_ZeroBalanceExceptionHandler")
public class ZeroBalanceExceptionHandler extends AbstractUiExceptionHandler {

    public ZeroBalanceExceptionHandler() {
        super(ZeroBalanceException.class.getName());
    }
    @Override
    protected void doHandle(String className, String message,
                            @Nullable Throwable throwable, UiContext context) {
        context.getNotifications().create(Notifications.NotificationType.ERROR)
                .withCaption("Error")
                .withDescription(message)
                .show();
    }
}
