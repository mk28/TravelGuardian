import os
import pandas as pd
import numpy as np

# Create folder to save synthetic data
output_folder = "synthetic_data"
os.makedirs(output_folder, exist_ok=True)

# Function to generate synthetic tourist data
def generate_tourist_data(n=1000):
    np.random.seed(42)
    data = {
        "Tourist_ID": range(1, n + 1),
        "Name": [f"Tourist_{i}" for i in range(1, n + 1)],
        "Country": np.random.choice(["India", "USA", "UK", "France", "Germany", "Japan"], n),
        "Age": np.random.randint(18, 70, n),
        "Gender": np.random.choice(["Male", "Female", "Other"], n),
        "Destination": np.random.choice(["Delhi", "Paris", "New York", "Tokyo", "Goa", "Munich"], n),
        "Check_in_Date": pd.date_range("2025-01-01", periods=n, freq="D"),
        "Check_out_Date": pd.date_range("2025-01-02", periods=n, freq="D"),
    }
    return pd.DataFrame(data)

# Function to generate synthetic incident data
def generate_incident_data(n=500):
    np.random.seed(24)
    data = {
        "Incident_ID": range(1, n + 1),
        "Tourist_ID": np.random.randint(1, 1000, n),
        "Incident_Type": np.random.choice(["Lost Item", "Medical Emergency", "Theft", "Accident", "Crowd Issue"], n),
        "Severity": np.random.choice(["Low", "Medium", "High"], n),
        "Location": np.random.choice(["Hotel", "Market", "Airport", "Monument", "Beach"], n),
        "Reported_Date": pd.date_range("2025-01-01", periods=n, freq="12h"),
        "Resolved": np.random.choice(["Yes", "No"], n),
    }
    return pd.DataFrame(data)

# Function to generate synthetic geofence alert data
def generate_geofence_data(n=700):
    np.random.seed(56)
    data = {
        "Alert_ID": range(1, n + 1),
        "Tourist_ID": np.random.randint(1, 1000, n),
        "Restricted_Area": np.random.choice(["Border Zone", "Construction Site", "Unsafe Market", "Cliff Area"], n),
        "Entry_Time": pd.date_range("2025-01-01", periods=n, freq="h"),
        "Exit_Time": pd.date_range("2025-01-01 01:00:00", periods=n, freq="h"),
        "Alert_Status": np.random.choice(["Triggered", "Resolved"], n),
    }
    return pd.DataFrame(data)

# Function to generate synthetic SOS request data
def generate_sos_data(n=300):
    np.random.seed(78)
    data = {
        "SOS_ID": range(1, n + 1),
        "Tourist_ID": np.random.randint(1, 1000, n),
        "SOS_Type": np.random.choice(["Health", "Safety", "Theft", "Natural Disaster"], n),
        "SOS_Time": pd.date_range("2025-01-01", periods=n, freq="2h"),
        "Response_Time_Minutes": np.random.randint(2, 60, n),
        "Resolved": np.random.choice(["Yes", "No"], n),
    }
    return pd.DataFrame(data)

# Generate all datasets
tourist_df = generate_tourist_data()
incident_df = generate_incident_data()
geofence_df = generate_geofence_data()
sos_df = generate_sos_data()

# Save them to CSV
tourist_df.to_csv(os.path.join(output_folder, "tourist_data.csv"), index=False)
incident_df.to_csv(os.path.join(output_folder, "incident_data.csv"), index=False)
geofence_df.to_csv(os.path.join(output_folder, "geofence_data.csv"), index=False)
sos_df.to_csv(os.path.join(output_folder, "sos_data.csv"), index=False)

print("-----------------------------------------------------")
print("Synthetic datasets generated inside the 'synthetic_data' folder:")
print("1. tourist_data.csv")
print("2. incident_data.csv")
print("3. geofence_data.csv")
print("4. sos_data.csv")
print("-----------------------------------------------------")
