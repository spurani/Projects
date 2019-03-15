using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Assignment_3.Controllers
{
    public class EmployeeEditContactInfo
    {
        
        public EmployeeEditContactInfo() { }

        [Key]
        public int EmployeeId { get; set; }
        public string Address { get; set; }


        public string City { get; set; }


        public string State { get; set; }


        public string Country { get; set; }

        public string PostalCode { get; set; }


        public string Phone { get; set; }


        public string Fax { get; set; }


        public string Email { get; set; }
    }
}