package sample.Metods;

public abstract class Colleague {
    protected Mediator mediator;

    Qweston receivedMessage;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void notifyColleague(Qweston message);

    public void receive(Qweston message) {
        this.receivedMessage = message;
    }

    public Qweston getReceivedMessage() {
        return this.receivedMessage;
    }
}