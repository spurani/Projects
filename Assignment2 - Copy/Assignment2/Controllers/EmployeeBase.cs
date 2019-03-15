using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Assignment2.Controllers
{
    public class EmployeeBase : EmployeeAdd
    {
        
        [Key]
        public int EmployeeId { get; set; }
    }
}