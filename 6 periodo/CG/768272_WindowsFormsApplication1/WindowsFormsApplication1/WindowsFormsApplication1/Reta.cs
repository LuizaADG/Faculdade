using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace WindowsFormsApplication1
{
    public class Reta
    {
        private double xInicial;
        private double yInicial;
        private double xFinal;
        private double yFinal;

        public Reta(double xInicial, double yInicial, double xFinal, double yFinal)
        {
            this.xInicial = xInicial;
            this.yInicial = yInicial;
            this.xFinal = xFinal;
            this.yFinal = yFinal;
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
            return this.xFinal;
        }
        public Double getYFinal()
        {
            return this.yFinal;
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
            this.xFinal = xFinal;
        }
        public void setYFinal(double yFinal)
        {
            this.yFinal = yFinal;
        }
    }

}
