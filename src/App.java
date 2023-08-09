public class App {
    public static void main(String[] args){
        Jogador j1 = new Jogador('X');
        Jogador j2 = new Jogador('O');
        Tabuleiro tab = new Tabuleiro(j1, j2);
        int jogada = 1;
        
        tab.exibirTabuleiro();

        while(tab.jogar()){
            System.out.println("Jogada " + jogada++ + ":");
            tab.exibirTabuleiro();
        }

        switch(tab.verificarVencedor()) {
            case 'D': System.out.println("O jogo terminou em empate!");
                break;
            case 'X': System.out.println("O jogador X ganhou!");
                break;
            case 'O': System.out.println("O jogador O ganhou!");
                break;
            default: System.out.println("Houve algum problema!");
        }
    }
}
