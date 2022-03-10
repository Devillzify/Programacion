package dofus;

public class Quest
{
    private int questId;
    private String text;

    public void setQuestId(int questId)
    {
        this.questId = questId;
    }

    public int getQuestId()
    {
        return questId;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return text;
    }

    @Override
    public String toString()
    {
        return "Quest{" +
                "questId=" + questId +
                ", text='" + text + '\'' +
                '}';
    }
}
