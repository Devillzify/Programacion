
public class Npc
{
    private int npcId;
    private String questTextId;
    private Quest[] quests;
    private int contador;

    public Npc ()
    {
        this.quests = new Quest[10];
        contador = 0;
    }


    public int getNpcId()
    {
        return npcId;
    }

    public void setNpcId(int id)    // NPC ID
    {
        this.npcId = id;
    }

    public String getQestTextId()
    {
        return questTextId;
    }

    public void setQuestTextId(String text) // TEXTO MISIONES
    {
        this.questTextId = text;
    }

    public Quest[] getQuest()
    {
        return quests;
    }

    public void setQuest(Quest[] quest)  // MISIONES
    {
        this.quests = quest;
    }
    public void addQuest(Quest quest)
    {
        quests[contador] = quest;
        contador++;

    }

    public String toString()
    {
        return "npcId = " + npcId + " quests = " + quests + " questTextId = " + questTextId;
    }



}
