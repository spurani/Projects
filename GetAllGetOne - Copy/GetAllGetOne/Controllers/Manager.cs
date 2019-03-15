using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
// new...
using AutoMapper;
using GetAllGetOne.Models;

namespace GetAllGetOne.Controllers
{
    public class Manager
    {
        // Reference to the data context
        private DataContext ds = new DataContext();

        // AutoMapper instance
        public IMapper mapper;

        public Manager()
        {
            // If necessary, add more constructor code here...

            // Configure the AutoMapper components
            var config = new MapperConfiguration(cfg =>
            {
                // Define the mappings below, for example...
                // cfg.CreateMap<SourceType, DestinationType>();
                // cfg.CreateMap<Employee, EmployeeBase>();
                cfg.CreateMap<Models.Customer, Controllers.CustomerBase>();
                cfg.CreateMap<Controllers.CustomerAdd,Models.Customer>();
                cfg.CreateMap<Controllers.CustomerBase, Controllers.CustomerEditContactInfoForm>();
            });

            mapper = config.CreateMapper();

            // Turn off the Entity Framework (EF) proxy creation features
            // We do NOT want the EF to track changes - we'll do that ourselves
            ds.Configuration.ProxyCreationEnabled = false;

            // Also, turn off lazy loading...
            // We want to retain control over fetching related objects
            ds.Configuration.LazyLoadingEnabled = false;
            
        }

        // Add methods below
        // Controllers will call these methods
        // Ensure that the methods accept and deliver ONLY view model objects and collections
        // The collection return type is almost always IEnumerable<T>

        // Suggested naming convention: Entity + task/action
        // For example:
        // ProductGetAll()
        public IEnumerable<CustomerBase> CustomerGetAll()
        {
           
            return mapper.Map<IEnumerable<Customer>,IEnumerable<CustomerBase>>(ds.Customers);
        }
        // ProductGetById()
        public CustomerBase CustomerGetById(int id)
        {
            var o = ds.Customers.Find(id);

            return (o == null) ? null : mapper.Map<Customer, CustomerBase>(o);
        }
        // ProductAdd()
        public CustomerBase CustomerAdd(CustomerAdd newItem)
        {
            var addedItem = ds.Customers.Add(mapper.Map<CustomerAdd, Customer>(newItem));
            ds.SaveChanges();

            return (addedItem == null) ? null : mapper.Map<Customer, CustomerBase>(addedItem);
        }
        // ProductEdit()
        public CustomerBase CustomerEditContactInfo(CustomerEditContactInfo newItem) {
            var o = ds.Customers.Find(newItem.CustomerId);
            if (o == null)
            {
                return null;
            }
            else {
                ds.Entry(o).CurrentValues.SetValues(newItem);
                ds.SaveChanges();
                return mapper.Map<Customer,CustomerBase>(o);
            }
        }
        // ProductDelete()
        public bool CustomerDelete(int id)

        {
            // Attempt to fetch the object to be deleted
            var itemToDelete = ds.Customers.Find(id);
            if (itemToDelete == null)
            {
               return false;
            }
            else
            {
                // Remove the object
                ds.Customers.Remove(itemToDelete);
                ds.SaveChanges();
                return true;
            }
        }
    }
}