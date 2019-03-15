using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace GetAllGetOne.Controllers
{
    public class CustomerBase : CustomerAdd
    {
        [Key]
        public int CustomerId { get; set; }

        public CustomerBase() { }
    }
}