using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class tela : Form
    {
        Bitmap areaDesenho;
        Color corPreenche;

        int cliques = 0; //contar os pontos iniciais
        
        /* Arrays preenchidos com as coordenadas dos pontos*/
        double [] xPontos = new double [4];
        double [] yPontos = new double [4];
        
        /*Booleans dos pontos selecionados pelos botões */
        Boolean ponto1 = false; 
        Boolean ponto2 = false;
        Boolean ponto3 = false;
        Boolean ponto4 = false;

        public tela()
        {
            InitializeComponent();
            areaDesenho = new Bitmap(imagem.Size.Width, imagem.Size.Height);
            corPreenche = Color.Black;
        }

        private void desenhar_Click(object sender, EventArgs e)
        {
            int x = (int)Convert.ToInt64(txtX.Text);
            int y = (int)Convert.ToInt64(txtY.Text);

            areaDesenho.SetPixel(x, y, corPreenche);
            imagem.Image = areaDesenho;
        }

        private void btCor_Click(object sender, EventArgs e)
        {
            DialogResult result = cdlg.ShowDialog();
            if (result == DialogResult.OK)
            {
                corPreenche = cdlg.Color;
            }
        }

        private void btApagar_Click(object sender, EventArgs e)
        {
            areaDesenho = new Bitmap(imagem.Size.Width, imagem.Size.Height);
            imagem.Image = areaDesenho;
        }

        private void imagem_MouseMove(object sender, MouseEventArgs e)
        {

        }
        private void Imagem_Click(object sender, EventArgs e)
        {

        }

        /*Detecta cliques na tela, cada coordenada do pixel é colocada nos arrays*/
        private void click(object sender, MouseEventArgs e)
        {
            cliques++;
            if (this.cliques == 1)
            {
                this.xPontos[0] = e.X;
                this.yPontos[0] = e.Y;

            }

            else if (this.cliques == 2)
            {
                this.xPontos[1] = e.X;
                this.yPontos[1] = e.Y;

            }
            else if (this.cliques == 3)
            {
                this.xPontos[2] = e.X;
                this.yPontos[2] = e.Y;

            }
            else if (this.cliques == 4)
            {
                this.xPontos[3] = e.X;
                this.yPontos[3] = e.Y;
                curvaBezier(xPontos,yPontos);//chamar função da curva após a seleção de 4 pontos
            }
            else if (this.cliques > 4)
            {
                mudarPonto(sender, e);//chamar quando cliques na tela forem detectados
            }
        }
        /*Método da curva de bezier*/
        void curvaBezier(double [] x , double [] y)
        {
            double xu = 0.0, yu = 0.0, u = 0.0;
            for (u = 0.0; u <= 1.0; u += 0.0001)
            {
                xu = Math.Pow(1 - u, 3) * x[0] + 3 * u * Math.Pow(1 - u, 2) * x[1] + 3 * Math.Pow(u, 2) * (1 - u) * x[2]
                     + Math.Pow(u, 3) * x[3];
                yu = Math.Pow(1 - u, 3) * y[0] + 3 * u * Math.Pow(1 - u, 2) * y[1] + 3 * Math.Pow(u, 2) * (1 - u) * y[2]
                    + Math.Pow(u, 3) * y[3];
                areaDesenho.SetPixel((int)xu, (int)yu, corPreenche);
                imagem.Image = areaDesenho;
            }
        }
        /*Métodos de detecção dos botões*/
        private void button1_Click(object sender, MouseEventArgs e)
        {
            ponto1 = true;
            
        }
        private void button2_Click(object sender, MouseEventArgs e)
        {
            ponto2 = true;
           
        }
        private void button3_Click(object sender, MouseEventArgs e)
        {
            ponto3 = true;

        }
        private void button4_Click(object sender, MouseEventArgs e)
        {
            ponto4 = true;

        }
        /*Método de mudança de pontos. Chamado quando a tela é clicada*/
        public void mudarPonto(object sender, MouseEventArgs e)
        {
            if (ponto1)
            {
                this.xPontos[0] = e.X;
                this.yPontos[0] = e.Y;
                ponto1 = false;
            }
            else if (ponto2)
            {
                this.xPontos[1] = e.X;
                this.yPontos[1] = e.Y;
                ponto2 = false;
            }
            else if (ponto3)
            {
                this.xPontos[2] = e.X;
                this.yPontos[2] = e.Y;
                ponto3 = false;
            }
            else if (ponto4)
            {
                this.xPontos[3] = e.X;
                this.yPontos[3] = e.Y;
                ponto4 = false;
            }
            /*Apagar e redesenhar a curva*/
            areaDesenho = new Bitmap(imagem.Size.Width, imagem.Size.Height);
            imagem.Image = areaDesenho;
            curvaBezier(xPontos, yPontos);
        }
    }
}