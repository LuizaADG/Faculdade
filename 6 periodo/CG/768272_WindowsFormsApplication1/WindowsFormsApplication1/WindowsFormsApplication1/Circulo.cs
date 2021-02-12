using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace WindowsFormsApplication1
{
    public class Circulo
    {
        private double xInicial;
        private double yInicial;
        private double xCentro;
        private double yCentro;
        private double raio;

        public Circulo(double xInicial, double yInicial, double xCentro, double yCentro,double raio)
        {
            this.xInicial = xInicial;
            this.yInicial = yInicial;
            this.xCentro = xCentro;
            this.yCentro = yCentro;
            this.raio = raio;
        }
         public Double getXInicial()
        {
            return this.xInicial;
        }
        public Double getYInicial()
        {
            return this.yInicial;
        }
        public Double getXFinal()
        {
            return this.xCentro;
        }
        public Double getYFinal()
        {
            return this.yCentro;
        }
        public Double getRaio()
        {
            return this.raio;
        }
        public void setXInicial(double xInicial)
        {
            this.xInicial = xInicial;
        }
        public void setYInicial(double yInicial)
        {
            this.yInicial = yInicial;
        }
        public void setXFinal(double xFinal)
        {
            this.xCentro = xFinal;
        }
        public void setYFinal(double yFinal)
        {
            this.yCentro = yFinal;
        }

        public void setRaio(double raio)
        {
            this.raio = raio;
        }
    }
}
