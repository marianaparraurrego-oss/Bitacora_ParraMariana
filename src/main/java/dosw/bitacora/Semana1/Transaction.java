package dosw.bitacora.Semana1;

public class Transaction {
    String id;
    double amount;
    boolean approved;

    Transaction(String id, double amount, boolean approved) {
        this.id = id;
        this.amount = amount;
        this.approved = approved;
    }

    @Override
    public String toString() {
        return id + " - $" + amount + " - Aprobada: " + approved;
    }
}
