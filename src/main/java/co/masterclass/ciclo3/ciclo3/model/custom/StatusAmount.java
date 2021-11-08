package co.masterclass.ciclo3.ciclo3.model.custom;

public class StatusAmount {
    private Integer completed;
    private Integer cancelled;

    public StatusAmount(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer complete) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }
}
