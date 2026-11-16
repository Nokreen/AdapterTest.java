// Целевой интерфейс
interface UsbPort {
    void chargeWithUsb();
}

//  Несовместимый класс
class EuropeanSocket {
    public void provide220Volts() {
        System.out.println("Розетка выдает 220V переменного тока.");
    }
}

//Адаптер
class PowerAdapter implements UsbPort {
    private EuropeanSocket socket;

    public PowerAdapter(EuropeanSocket socket) {
        this.socket = socket;
    }

    @Override
    public void chargeWithUsb() {
        socket.provide220Volts();
        System.out.println("-> Адаптер преобразовал 220V в 5V USB.");
        System.out.println("Телефон начал заряжаться! ");
    }
}

//  Телефон
class Phone {
    public void charge(UsbPort port) {
        System.out.println("Подключаем зарядку к телефону...");
        port.chargeWithUsb();
    }
}

// Тест
public class Main {
    public static void main(String[] args) {
        EuropeanSocket socket = new EuropeanSocket();
        UsbPort adapter = new PowerAdapter(socket);
        Phone myPhone = new Phone();
        myPhone.charge(adapter);
    }
}