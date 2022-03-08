package dofus;

import javax.swing.*;

public class CreateNpc
{
    public static void main(String[] args)
    {
        Npc Baggira = new Npc();
        Quest quest = new Quest();
        Quest quest1 = new Quest();
        Quest quest2 = new Quest();
        quest2.setText("bbbb");
        quest2.setQuestId(3);
        quest1.setQuestId(2);
        quest1.setText("aaaaa");
        quest.setQuestId(1);
        quest.setText("dddd");

        Baggira.setId(1);

        Baggira.setPosition(1);

        Baggira.setQuest(new Quest[3]);

        Baggira.getQuest()[0] = quest;
        Baggira.getQuest()[1] = quest1;
        Baggira.getQuest()[2] = quest2;



        Baggira.setTextid(1);




        System.out.println(Baggira.getId());
        System.out.println(Baggira.getPosition());
        System.out.println(Baggira.getTextid());

        for(int i = 0; i < Baggira.getQuest().length; i++ )
        {
            System.out.println(Baggira.getQuest()[i]);
        }

        Baggira.atacar();

    }

}
