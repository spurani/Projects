using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
// new...
using AutoMapper;
using Assignment_3.Models;

namespace Assignment_3.Controllers
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

                cfg.CreateMap<Models.Employee,Controllers.EmployeeBase>();
                cfg.CreateMap<Models.Track,Controllers.TrackBase>();
                cfg.CreateMap<Controllers.EmployeeBase, Controllers.EmployeeEditContactInfoForm>();
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
        // ProductGetById()
        // ProductAdd()
        // ProductEdit()
        // ProductDelete()

        public IEnumerable<EmployeeBase> EmployeeGetAll() {
            return mapper.Map<IEnumerable<Employee>, IEnumerable<EmployeeBase>>(ds.Employees);
        }

        public EmployeeBase EmployeeGetById(int id) {
            var o = ds.Employees.Find(id);
            return (o == null) ? null : mapper.Map<Employee,EmployeeBase>(o);
        }

        public IEnumerable<TrackBase> TrackGetAll() {
            return mapper.Map<IEnumerable<Track>,IEnumerable<TrackBase>>(ds.Tracks);
        }

        public TrackBase TrackGetById(int id)
        {
            var o = ds.Tracks.Find(id);
            if (o == null)
            {
                return null;
            }
            else {
                return mapper.Map<Track,TrackBase>(o);
            }
        }
        public EmployeeBase EmployeeEditContactInfo(EmployeeEditContactInfo newItem) {
            var o = ds.Employees.Find(newItem.EmployeeId);

            if (o == null)
            {
                return null;
            }
            else {
                ds.Entry(o).CurrentValues.SetValues(newItem);
                ds.SaveChanges();
                return mapper.Map<Employee,EmployeeBase>(o);

            }
        }

        public IEnumerable<TrackBase> TrackGetAllPop() {
            var o = ds.Tracks.Where(p=>p.GenreId==9).OrderBy(p=>p.Name);

            return mapper.Map<IEnumerable<Track>,IEnumerable<TrackBase>>(o);

        }

        public IEnumerable<TrackBase> TrackGetAllDeepPurple()
        {
            var o = ds.Tracks.Where(p => p.Composer.Contains("Jon Lord")).OrderBy(p => p.TrackId);
            return mapper.Map<IEnumerable<Track>,IEnumerable<TrackBase>>(o);
        }

        public IEnumerable<TrackBase> TrackGetAllTop100Longest()
        {
            var o = ds.Tracks.OrderBy(p=>p.Milliseconds).Take(100);
            return mapper.Map<IEnumerable<Track>,IEnumerable<TrackBase>>(o);
        }
    }
}