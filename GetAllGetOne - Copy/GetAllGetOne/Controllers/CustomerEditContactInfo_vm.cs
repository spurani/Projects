using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace GetAllGetOne.Controllers
{
    public class CustomerEditContactInfo
    {
        public CustomerEditContactInfo() { }



        [Key]

        public int CustomerId { get; set; }



        public string Phone { get; set; }

        public string Fax { get; set; }

        public string Email { get; set; }
    }
}