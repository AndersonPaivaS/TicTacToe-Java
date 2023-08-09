public class Tabuleiro {
    char[][] tab = new char[3][3];
    private char j1;
    private char j2;

    private char jogadorAtual;
    private Jogador objetoJ1, objetoJ2;
    private int linha;
    private int coluna;
    

    public Tabuleiro(Jogador objetoJ1, Jogador objetoJ2) {

        for(int L = 0; L < 3; L++){
            for(int C = 0; C < 3; C++){
                tab[L][C] = '*';
            }
        }

        this.objetoJ1 = objetoJ1;
        this.objetoJ2 = objetoJ2;

        j1 = objetoJ1.getMarcador();
        j2 = objetoJ2.getMarcador();

        jogadorAtual = j1;
    }

    public void exibirTabuleiro(){
        for(int L = 0; L < 3; L++){
            for(int C = 0; C < 3; C++){
                System.out.print(tab[L][C] + " ");
            }
            System.out.println();
        }
    }

    public boolean jogar(){
        if(verificarVencedor() == 'N'){
            if(jogadorAtual == j1){
                do{
                    linha = objetoJ1.escolherLinha();
                    coluna = objetoJ1.escolherColuna();
                } while(tab[linha][coluna] != '*');
                tab[linha][coluna] = j1;

                jogadorAtual = j2;
            } else {
                do{
                    linha = objetoJ2.escolherLinha();
                    coluna = objetoJ2.escolherColuna();
                } while(tab[linha][coluna] != '*');
                tab[linha][coluna] = j2;

                jogadorAtual = j1;
            }
            return true;
        } else {
            return false;
        }
    }

    public char verificarVencedor(){
        // Verificar Colunas
        for(int C = 0; C < 3; C++){
            if(tab[C][0] == tab[C][1] && tab[C][1] == tab[C][2] && tab[C][2] != '*'){
                return tab[C][0];
            }
        }

        // Verificar Linhas
        for(int L = 0; L < 3; L++){
            if(tab[0][L] == tab[1][L] && tab[1][L] == tab[2][L] && tab[2][L] != '*'){
                return tab[0][L];
            }
        }

        //Verificar Diagonais
        for(int D = 0; D < 3; D++){
            if(tab[0][0] == tab[1][1] && tab[1][1] == tab[2][2] && tab[1][1] != '*' || tab[0][2] == tab[1][1] && tab[1][1] == tab[2][0] && tab[1][1] != '*'){
                return tab[1][1];
            }
        }

        boolean locationAvailable = false;
        for(int L = 0; L < 3; L++){
            for(int C = 0; C < 3; C++){
                if(tab[L][C] == '*'){
                    locationAvailable = true;
                    break;
                }
            }
        }
        return locationAvailable ? 'N' : 'D';
    }

    public void reiniciarTabuleiro(){
        for(int L = 0; L < 3; L++){
            for(int C = 0; C < 3; C++){
                tab[L][C] = '*';
            }
        }
    }

    public void setIniciante(int ini){
        if(ini == 2){
            jogadorAtual = 'O';
        } else {
            jogadorAtual = 'X';
        }
    }
}


