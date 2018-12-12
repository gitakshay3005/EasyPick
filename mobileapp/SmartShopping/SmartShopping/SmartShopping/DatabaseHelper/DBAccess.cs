using SmartShopping.Interfaces;
using SQLite;
using System.Collections.Generic;
using System.Linq;
using Xamarin.Forms;

namespace SmartShopping.DatabaseHelper
{
    public class DBAccess
    {
        #region DataMembers

        private static object locker = new object();
        private static DBAccess instance = new DBAccess();
        #endregion

        #region Properties

        /// <summary>
        /// Returns DB instance
        /// </summary>
        public static DBAccess Instance
        {
            get
            {
                return instance;
            }

        }

        /// <summary>
        /// DB connectoin property
        /// </summary>
        public SQLiteConnection DBConnection { get; set; }

        IDBConnectionService SQLite
        {
            get
            {
                return DependencyService.Get<IDBConnectionService>();

            }
        }


        #endregion

        #region Constructor

        /// <summary>
        /// Creates DB connection
        /// </summary>
        public DBAccess()
        {
            DBConnection = SQLite.GetConnection("SmartShopping");
        }

        #endregion

        #region Methods

        /// <summary>
        /// Generic method to create DB table
        /// </summary>
        /// <typeparam name="T"> Generic table name object </typeparam>
        public void CreateTable<T>()
        {
            lock (locker)
            {
                DBConnection.CreateTable<T>();
            }
        }

        /// <summary>
        /// Saves table data
        /// </summary>
        /// <typeparam name="T"> Generic table name object </typeparam>
        /// <param name="item"> Generic table name object </param>
        /// <returns> Returns autoincremented primary key if it has one  </returns>
        public int SaveItem<T>(T item)
        {
            lock (locker)
            {
                return DBConnection.Insert(item);
            }
        }

        /// <summary>
        /// Saves table data list
        /// </summary>
        /// <typeparam name="T"> Generic table name object </typeparam>
        /// <param name="listItem"> Generic table name object list </param>
        /// <returns> Number of rows added </returns>
        public int SaveAllItem<T>(IList<T> listItem)
        {
            lock (locker)
            {
                return DBConnection.InsertAll(listItem);
            }
        }

        /// <summary>
        /// Updates table data
        /// </summary>
        /// <typeparam name="T">  Generic table name object </typeparam>
        /// <param name="item">  Generic table name object </param>
        /// <returns>Total number of rows updated </returns>
        public int UpdateItem<T>(T item)
        {
            lock (locker)
            {
                return DBConnection.Update(item);
            }
        }

        /// <summary>
        /// Updates table data list 
        /// </summary> 
        /// <typeparam name="T"> Generic table name object</typeparam>
        /// <param name="item"> Generic table name object list </param>
        /// <returns> Total number of rows updated </returns>
        public int UpdateAllItem<T>(IList<T> item)
        {
            lock (locker)
            {
                return DBConnection.UpdateAll(item);
            }
        }

        /// <summary>
        /// Gets table data
        /// </summary>
        /// <typeparam name="T"> Generic table name object </typeparam>
        /// <returns>List of table data </returns>
        public IEnumerable<T> GetItems<T>() where T : new()
        {
            lock (locker)
            {
                return (from i in DBConnection.Table<T>() select i).ToList();
            }
        }

        /// <summary>
        /// Deletes table data on given ID
        /// </summary>
        /// <typeparam name="T"> Generic table name object </typeparam>
        /// <param name="id"> Id parameter to delete </param>
        /// <returns>Number of rows deleted </returns>
        public int DeleteItem<T>(int id)
        {
            lock (locker)
            {
                return DBConnection.Delete<T>(id);
            }
        }
        /// <summary>
        /// Deletes table data on given ID
        /// </summary>
        /// <typeparam name="T"> Generic table name object </typeparam>
        /// <param name="id"> Id parameter to delete </param>
        /// <returns>Number of rows deleted </returns>
        public int DeleteItem<T>(string id)
        {
            lock (locker)
            {
                return DBConnection.Delete<T>(id);
            }
        }

        /// <summary>
        /// Deletes all table data on given ID
        /// </summary>
        /// <typeparam name="T"> Generic table name object </typeparam>
        /// <returns>Number of rows deleted </returns>
        public int DeleteAll<T>()
        {
            lock (locker)
            {
                return DBConnection.DeleteAll<T>();
            }

        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="query"></param>
        /// <param name="args"></param>
        /// <returns></returns>
        public int ExecuteQuery(string query, params object[] args)
        {
            lock (locker)
            {
                return DBConnection.Execute(query, args);
            }
        }        

        #endregion
    }
}
