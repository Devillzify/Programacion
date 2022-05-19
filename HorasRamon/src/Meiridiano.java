enum Meridiano
{
    AM("Ante Meridiem", "Antes del mediodia"),
    PM("Post Meridiem", "Después del mediodia");

    public final String label, spanish;

    private Meridiano(String label, String spanish)
    {
        this.label = label;
        this.spanish = spanish;
    }
}