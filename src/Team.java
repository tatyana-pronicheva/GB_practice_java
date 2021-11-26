public class Team {
    String teamName;
    Creature[] participants = new Creature[4];

    public Team(Creature participant1,
                Creature participant2,
                Creature participant3,
                Creature participant4,
                String teamName) {
        this.participants[0] = participant1;
        this.participants[1] = participant2;
        this.participants[2] = participant3;
        this.participants[3] = participant4;
        this.teamName = teamName;
    };

    public void printWinParticipants(){
        System.out.println("Выигравшие участники");
        for (int i = 0;i< participants.length;i++){
            if (participants[i].isWinner == true) {
                System.out.println((i + 1) + ") " + participants[i].creatureName + ", прыгает на " + participants[i].maxJumpHeight +
                        "см. Может пробежать " + participants[i].maxRunLength + "см.");
            }
        }
    }
    public void printAllParticipants(){
        System.out.println("Все участники");
        for (int i = 0;i< participants.length;i++){
            System.out.println((i+1) +") " + participants[i].creatureName +", прыгает на "+participants[i].maxJumpHeight+
                    "см. Может пробежать "+participants[i].maxRunLength+"см.");
        }
    }

}
