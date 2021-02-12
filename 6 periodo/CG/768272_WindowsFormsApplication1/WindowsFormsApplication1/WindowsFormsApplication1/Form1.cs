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

        double xi, yi, xf, yf;
        int cliques = 0;

        bool dda = false;
        bool brenham = false;
        bool circulo = false;


        const int INSIDE = 0; // 0000 
        const int LEFT = 1;   // 0001 
        const int RIGHT = 2;  // 0010 
        const int BOTTOM = 4; // 0100 
        const int TOP = 8;    // 1000

        List<Reta> retas = new List<Reta>();
        List<Circulo> circunferencia = new List<Circulo>();


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
        private void Ddareta_Click(object sender, EventArgs e)
        {
            this.dda = true;
        }

        private void Button2_MouseClick(object sender, MouseEventArgs e)
        {
            this.brenham = true;
        }
        private void Button1_MouseClick(object sender, MouseEventArgs e)
        {
            this.circulo = true;
        }
        private void Tela_Load(object sender, EventArgs e)
        {

        }
        /*Detecta cliques na tela*/
        private void click(object sender, MouseEventArgs e)
        {
            cliques++;
            if (this.cliques % 2 == 1)
            {
                this.xi = e.X;
                this.yi = e.Y;
            }

            else if (this.cliques % 2 == 0)
            {
                this.xf = e.X;
                this.yf = e.Y;
                if (dda == true)
                {
                    Reta reta = new Reta(this.xi, this.yi, this.xf, this.yf);
                    retas.Add(reta);
                    cohenSutherlandClip(this.xi, this.yi, this.xf, this.yf, 0);
                }
                else if (this.brenham == true)
                {
                    Reta reta = new Reta(this.xi, this.yi, this.xf, this.yf);
                    retas.Add(reta);
                    cohenSutherlandClip(this.xi, this.yi, this.xf, this.yf, 0);
                }
                else if (this.circulo == true)
                {
                    double r = raio(this.xi, this.yi, this.xf, this.yf);
                    Circulo circular = new Circulo(this.xi, this.yi, this.xf, this.yf, r);
                    circunferencia.Add(circular);
                    cohenSutherlandClip(this.xi, this.yi, this.xf, this.yf, r);
                }
            }

        }
        /*Algoritmo de Cohen-Sutherland para recorte*/
        private int regiaoTela(double x, double y)
        {

            int x_min = imagem.Bounds.Location.X;
            int y_min = imagem.Bounds.Location.Y;
            int x_max = imagem.Bounds.Width + imagem.Bounds.Location.X;
            int y_max = imagem.Bounds.Height + imagem.Bounds.Location.Y;

            int codigo = 0;
            if (x < x_min)
            {
                codigo = codigo + 1;
            }
            else if (x > x_max)
            {
                codigo = codigo + 2;
            }
            if (y < y_min)
            {
                codigo = codigo + 4;
            }
            else if (y > y_max)
            {
                codigo = codigo + 8;
            }
            return codigo;
        }
        public void cohenSutherlandClip(double x1, double y1,double x2, double y2, double r)
        {

            int x_min = imagem.Bounds.Location.X;
            int y_min = imagem.Bounds.Location.Y;
            int x_max = imagem.Bounds.Width + imagem.Bounds.Location.X;
            int y_max = imagem.Bounds.Height + imagem.Bounds.Location.Y;


            // regiões dos dois pontos
            int code1 = regiaoTela(x1, y1);
            int code2 = regiaoTela(x2, y2);

            // Inicializa como falso, reta fora da região
            bool accept = false;

            while (true)
            {
                if ((code1 == 0) && (code2 == 0))
                {
                    // dois ponto estão dentro dos parâmetros da tela
                    accept = true;
                    break;
                }
                else if ((code1 & code2)!=0)
                {
                    // testar se os dois pontos estão fora dos parâmetros da tela 
                    break;
                }
                else
                {
                    int code_out;
                    double x, y;

                    if (code1 != 0)
                    {
                        code_out = code1;
                    }
                    else
                    {
                        code_out = code2;
                    }
                    if ((code_out & TOP)!=0)
                    {
                        // ponto fora da tela 
                        x = x1 + (x2 - x1) * (y_max - y1) / (y2 - y1);
                        y = y_max;
                    }else if ((code_out & BOTTOM)!=0)
                    {
                        // ponto abaixo da tela 
                        x = x1 + (x2 - x1) * (y_min - y1) / (y2 - y1);
                        y = y_min;
                    }else if ((code_out & RIGHT)!=0)
                    {
                        // ponto à direita da tela 
                        y = y1 + (y2 - y1) * (x_max - x1) / (x2 - x1);
                        x = x_max;
                    }else if ((code_out & LEFT)!=0)
                    {
                        // ponto à esquerda da tela 
                        y = y1 + (y2 - y1) * (x_min - x1) / (x2 - x1);
                        x = x_min;
                    }
                    else
                    {
                        x = double.NaN;
                        y = double.NaN;
                    }
                    // Interseção encontrada 
                    // Substituir ponto fora da tela por ponto da interseção 
                    if (code_out == code1)
                    {
                        x1 = x;
                        y1 = y;
                        code1 = regiaoTela(x1, y1);
                    }
                    else
                    {
                        x2 = x;
                        y2 = y;
                        code2 = regiaoTela(x2, y2);
                    }
                }
            }
            if (accept)
            {
                //desenhar de acordo com a seleção
                    if(dda){
                        retadda(x1, y1, x2,y2);
                    }else if(brenham){
                        retabresenham(x1, y1, x2, y2);
                    }else if(circulo){
                        circulos(x1, y1,r, x2, y2);                    
                    }
            }
        }
        /*Algoritmos de reflexão*/
        private void reflexaoEmX(object sender, MouseEventArgs e)
        {
            //Pegar o ponto central
            int xCentral =  ((imagem.Bounds.Width + imagem.Bounds.Location.X - 1) + (imagem.Bounds.Location.X)) / 2;
            int yCentral =  ((imagem.Bounds.Height + imagem.Bounds.Location.Y - 1) + (imagem.Bounds.Location.Y)) / 2;
            areaDesenho.Dispose();
            areaDesenho = new Bitmap(imagem.Size.Width, imagem.Size.Height);
            if (retas != null)
            {
                foreach(var item in retas){
                    //para fazer a reflexão, devemos calcular onde o novo ponto estará a partir da distância entre ele e o meio
                    item.setXInicial(item.getXInicial()-2*(item.getXInicial()-xCentral));
                    item.setXFinal(item.getXFinal()-2*(item.getXFinal()-xCentral));
                    this.dda=true;
                    cohenSutherlandClip(item.getXInicial(), item.getYInicial(), item.getXFinal(), item.getYFinal(),0);
                    this.dda=false;
                }
            }
               if (circunferencia != null)
            {
                foreach(var item in circunferencia){
                    //para fazer a reflexão, devemos calcular onde o novo ponto estará a partir da distância entre ele e o meio
                    item.setXInicial(item.getXInicial()-2*(item.getXInicial()-xCentral));
                    item.setXFinal(item.getXFinal()-2*(item.getXFinal()-xCentral));
                    this.circulo=true;
                    cohenSutherlandClip(item.getXInicial(), item.getYInicial(), item.getXFinal(), item.getYFinal(),item.getRaio());
                    this.circulo=false;
                }
            }
                imagem.Image = areaDesenho;
        }

        private void reflexaoEmY(object sender, MouseEventArgs e)
        {
            //Pegar o ponto central
            int xCentral = ((imagem.Bounds.Width + imagem.Bounds.Location.X - 1) + (imagem.Bounds.Location.X)) / 2;
            int yCentral = ((imagem.Bounds.Height + imagem.Bounds.Location.Y - 1) + (imagem.Bounds.Location.Y)) / 2;
            areaDesenho.Dispose();
            areaDesenho = new Bitmap(imagem.Size.Width, imagem.Size.Height);
            if (retas != null)
            {
                foreach (var item in retas)
                {
                    //para fazer a reflexão, devemos calcular onde o novo ponto estará a partir da distância entre ele e o meio
                    item.setYInicial(item.getYInicial() - 2 * (item.getYInicial() - yCentral));
                    item.setYFinal(item.getYFinal() - 2 * (item.getYFinal() - yCentral));
                    this.dda = true;
                    cohenSutherlandClip(item.getXInicial(), item.getYInicial(), item.getXFinal(), item.getYFinal(),0);
                    this.dda = false;
                }
                imagem.Image = areaDesenho;
            }
            if (circunferencia != null)
            {
                foreach (var item in circunferencia)
                {
                    //para fazer a reflexão, devemos calcular onde o novo ponto estará a partir da distância entre ele e o meio
                    item.setYInicial(item.getYInicial() - 2 * (item.getYInicial() - yCentral));
                    item.setYFinal(item.getYFinal() - 2 * (item.getYFinal() - yCentral));
                    this.circulo = true;
                    cohenSutherlandClip(item.getXInicial(), item.getYInicial(), item.getXFinal(), item.getYFinal(),item.getRaio());
                    this.circulo = false;
                }
                imagem.Image = areaDesenho;
            }
        }

        private void reflexaoEmXY(object sender, MouseEventArgs e)
        {
            //Pegar o ponto central
            int xCentral = ((imagem.Bounds.Width + imagem.Bounds.Location.X - 1) + (imagem.Bounds.Location.X)) / 2;
            int yCentral = ((imagem.Bounds.Height + imagem.Bounds.Location.Y - 1) + (imagem.Bounds.Location.Y)) / 2;
            areaDesenho.Dispose();
            areaDesenho = new Bitmap(imagem.Size.Width, imagem.Size.Height);
            if (retas != null)
            {
                foreach (var item in retas)
                {
                    //para fazer a reflexão, devemos calcular onde o novo ponto estará a partir da distância entre ele e o meio
                    item.setXInicial(item.getXInicial() - 2 * (item.getXInicial() - xCentral));
                    item.setXFinal(item.getXFinal() - 2 * (item.getXFinal() - xCentral));
                    item.setYInicial(item.getYInicial() - 2 * (item.getYInicial() - yCentral));
                    item.setYFinal(item.getYFinal() - 2 * (item.getYFinal() - yCentral));
                    this.dda = true;
                    cohenSutherlandClip(item.getXInicial(), item.getYInicial(), item.getXFinal(), item.getYFinal(),0);
                    this.dda = false;
                }
                imagem.Image = areaDesenho;
            }
            if (circunferencia != null)
            {
                foreach (var item in circunferencia)
                {
                    //para fazer a reflexão, devemos calcular onde o novo ponto estará a partir da distância entre ele e o meio
                    item.setXInicial(item.getXInicial() - 2 * (item.getXInicial() - xCentral));
                    item.setXFinal(item.getXFinal() - 2 * (item.getXFinal() - xCentral));
                    item.setYInicial(item.getYInicial() - 2 * (item.getYInicial() - yCentral));
                    item.setYFinal(item.getYFinal() - 2 * (item.getYFinal() - yCentral));
                    this.circulo = true;
                    cohenSutherlandClip(item.getXInicial(), item.getYInicial(), item.getXFinal(), item.getYFinal(),item.getRaio());
                    this.circulo = false;
                }
                imagem.Image = areaDesenho;
            }
        }
        //Algoritmo de cálculo do raio da circunferência
        private double raio(double xi, double yi, double xf, double yf)
        {
            return Math.Sqrt(Math.Pow((int)(xf - xi), 2) + Math.Pow((int)(yf - yi), 2) * 1.0);
        }
        /*Algoritmos para desenhar retas - DDA e Bresenham*/
        private void retadda(double xi, double yi, double xf, double yf)
        {
            double x = xi, y = yi;
            int passos = 0;
            double dx = xf - xi;
            double dy = yf - yi;
            double xincr = 0, yincr = 0;
            if (Math.Abs(dx) >= Math.Abs(dy)) passos = (int)Math.Abs(dx);
            else
            {
                passos = (int)Math.Abs(dy);
            }
            xincr = dx / passos;
            yincr = dy / passos;
            for (int i = 0; i < passos; i++)
            {
                x += xincr;
                y += yincr;
                areaDesenho.SetPixel((int)Math.Round(x), (int)Math.Round(y), corPreenche);
                imagem.Image = areaDesenho;
            }
            this.dda = false;
        }
        private void retabresenham(double xi, double yi, double xf, double yf)
        {
            double dx, dy, x, y, i, const1, const2, p, incry, incrx;
            x = xi;
            y = yi;
            dx = xf - xi;
            dy = yf - yi;
            if (dx >= 0) incrx = 1;
            else
            {
                incrx = -1; dx = -dx;
            }
            if (dy >= 0) incry = 1;
            else
            {
                incry = -1; dy = -dy;
            }
            areaDesenho.SetPixel((int)x, (int)y, corPreenche);
            imagem.Image = areaDesenho;
            if (dy < dx)
            {
                p = 2 * (dy - dx);
                const1 = 2 * dy;
                const2 = 2 * (dy - dx); for (i = 0; i < dx; i++)
                {
                    x += incrx; if (p < 0) p += const1;
                    else
                    {
                        y += incry;
                        p += const2;
                    }
                    areaDesenho.SetPixel((int)x, (int)y, corPreenche);
                    imagem.Image = areaDesenho;
                }
            }
            else
            {
                p = 2 * (dx - dy);
                const1 = 2 * dx;
                const2 = 2 * (dx - dy);
                for (i = 0; i < dy; i++)
                {
                    y += incry;
                    if (p < 0) p += const1;
                    else { x += incrx; p += const2; }
                    areaDesenho.SetPixel((int)x, (int)y, corPreenche);
                    imagem.Image = areaDesenho;
                }
            }
            this.brenham = false;
        }
        /*Algoritmo de desenhar circulos*/
        private void plotaSimetricos(double x, double y, double xc, double yc)
        {
            areaDesenho.SetPixel(((int)xc + (int)x), ((int)yc + (int)y), corPreenche);
            imagem.Image = areaDesenho;

            areaDesenho.SetPixel(((int)xc + (int)x), ((int)yc - (int)y), corPreenche);
            imagem.Image = areaDesenho;

            areaDesenho.SetPixel(((int)xc - (int)x), ((int)yc + (int)y), corPreenche);
            imagem.Image = areaDesenho;

            areaDesenho.SetPixel(((int)xc - (int)x), ((int)yc - (int)y), corPreenche);
            imagem.Image = areaDesenho;

            areaDesenho.SetPixel(((int)xc + (int)y), ((int)yc + (int)x), corPreenche);
            imagem.Image = areaDesenho;

            areaDesenho.SetPixel(((int)xc + (int)y), ((int)yc - (int)x), corPreenche);
            imagem.Image = areaDesenho;

            areaDesenho.SetPixel(((int)xc - (int)y), ((int)yc + (int)x), corPreenche);
            imagem.Image = areaDesenho;

            areaDesenho.SetPixel(((int)xc - (int)y), ((int)yc - (int)x), corPreenche);
            imagem.Image = areaDesenho;
        }
        private void circulos(double xi, double yi, double r, double xc, double yc)
        {
            int x = 0;
            int y = (int)r;
            double p = 3 - (2 * r);
            plotaSimetricos(x, y, xc, yc);
            while (x < y) {
                if (p < 0) p += (4 * x) + 6;
                else
                {
                    p += 4 * (x - y) + 10;
                    y--;
                }
                x++;
                plotaSimetricos(x, y, xc, yc);
            }
            this.circulo = false;
        }
    }
}
