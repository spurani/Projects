using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace GetAllGetOne.Controllers
{
    public class CustomersController : Controller
    {
        private Manager m = new Manager();
        // GET: Customers
        public ActionResult Index()
        {
            var c = m.CustomerGetAll();
            return View(c);
        }

        // GET: Customers/Details/5
        public ActionResult Details(int? id)
        {
            var o = m.CustomerGetById(id.GetValueOrDefault());

            if (o == null)
            {
                return HttpNotFound();
            }
            else
            {
                return View(o);
            }
        }

        // GET: Customers/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Customers/Create
        [HttpPost]
        public ActionResult Create(CustomerAdd newItem)
        {
            if (!ModelState.IsValid)
            {
                return View(newItem);
            }

            var addedItem = m.CustomerAdd(newItem);

            if (addedItem == null)
            {
                return View(newItem);
            }
            else
            {
                return RedirectToAction("details",new { id = addedItem.CustomerId});
            }

        }

        // GET: Customers/Edit/5
        public ActionResult Edit(int? id)
        {
            var o = m.CustomerGetById(id.GetValueOrDefault());

            if (o == null)
            {
                return HttpNotFound();
            }
            else
            {
                var editForm = m.mapper.Map<CustomerBase,CustomerEditContactInfoForm>(o);
                return View(editForm);
            }
        }

        // POST: Customers/Edit/5
        [HttpPost]
        public ActionResult Edit(int? id, CustomerEditContactInfo newItem)
        {
            if (!ModelState.IsValid)
            {
                return RedirectToAction("edit",new { id=newItem.CustomerId});
            }

            if (id.GetValueOrDefault() != newItem.CustomerId)
            {
                return RedirectToAction("index");
            }

            var editedItem = m.CustomerEditContactInfo(newItem);
            if (editedItem == null)
            {
                return RedirectToAction("edit", new { id = newItem.CustomerId });
            }
            else
            {
                return RedirectToAction("details",new { id = newItem.CustomerId});
            }
        }

        // GET: Customers/Delete/5
        public ActionResult Delete(int? id)
        {
            var itemToDelete = m.CustomerGetById(id.GetValueOrDefault());
            if (itemToDelete == null)
            {
                // Don't leak info about the delete attempt
                // Simply redirect
                return RedirectToAction("index");
            }
            else
            {
                return View(itemToDelete);
            }
        }

        // POST: Customers/Delete/5
        [HttpPost]
        public ActionResult Delete(int? id, FormCollection collection)
        {
            var result = m.CustomerDelete(id.GetValueOrDefault());

            return RedirectToAction("index");


        }
    }
}
