package dofus;

import java.util.List;

public class Npc
{
    private int id;

    private int position;

    private Quest[] quest;

    private int textid;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public Quest[] getQuest()
    {
        return quest;
    }

    public void setQuest(Quest[] quest)
    {
        this.quest = quest;
    }

    public int getTextid()
    {
        return textid;
    }

    public void setTextid(int textid)
    {
        this.textid = textid;
    }

    public void atacar()
    {
        System.out.println("atacando");
    }
}
