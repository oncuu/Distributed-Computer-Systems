using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace Client
{
    class S1mpleCallback : ServiceReference1.IService1Callback
    {
        public void NumberOfNukesLaunched(int a)
        {
            Console.WriteLine(a);
        }
    }
    class Program
    {
        static async Task Main(string[] args)
        {
            InstanceContext insc = new InstanceContext(new S1mpleCallback());
            ServiceReference1.Service1Client s1c = new ServiceReference1.Service1Client(insc);
            Console.WriteLine(s1c.GetData(20));
            //s1c.LaunchTheNukes();

            InstanceContext ic2 = new InstanceContext(new S1mpleCallback());
            ServiceReference1.Service1Client s2c = new ServiceReference1.Service1Client(ic2);
                        
            await s1c.LaunchTheNukesAsync();

            Console.WriteLine(await s1c.AddNumberAsync(1, 2));
            Console.WriteLine("Enter your age:");
            int age = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Your age is: " + await s1c.ShowDataAsync(age));
            Console.WriteLine("Enter num 1: ");
            int num1 = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Enter num 2: ");
            int num2 = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Okay, so here we go for basic operations \nwrite  'add', 'sub', 'mult', 'div'");

            while (Console.ReadLine() != "stop")
            {
                if (Console.ReadLine() == "add")
                {
                    Console.WriteLine("Num1 + Num2 : " + await s1c.AddNumberAsync(num1, num2));
                }
                if (Console.ReadLine() == "sub")
                {
                    Console.WriteLine("Num1 - Num2 : " + await s1c.SubNumberAsync(num1, num2));
                }
                if (Console.ReadLine() == "mult")
                {
                    Console.WriteLine("Num1 * Num2 : " + await s1c.MultNumberAsync(num1, num2));
                }
                if (Console.ReadLine() == "div")
                {
                    Console.WriteLine("Num1 / Num2 : " + await s1c.DivNumberAsync(num1, num2));
                }
            }
            Console.ReadLine();
        }
    }
}
