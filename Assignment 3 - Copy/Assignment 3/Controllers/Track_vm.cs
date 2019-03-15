using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Assignment_3.Controllers
{
    public class TrackBase
    {
        public TrackBase()
        {
            Composer = "";
            Milliseconds = 0;
            Bytes = 0;
            Name = "";
            UnitPrice = 0.00;
        }

        public int TrackId { get; set; }

        [Required]
        [StringLength(200)]
        public string Name { get; set; }

        public int? AlbumId { get; set; }

        public int MediaTypeId { get; set; }

        public int? GenreId { get; set; }

        [StringLength(220)]
        public string Composer { get; set; }

        [Display(Name="Tracks length in milliseconds")]
        public int Milliseconds { get; set; }

        public int? Bytes { get; set; }

        [Display(Name="Selling Price")]
        public double UnitPrice { get; set; }
    }
}